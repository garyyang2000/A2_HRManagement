private boolean isMultipart;	
	private int maxFileSize = 60 * 1024 * 1024; // 60 MB
	private int maxMemSize = 5 * 1024 * 1024; // 5 MB
	private File file;
	static int count = 0;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			request.setAttribute("message", "Sorry, No file upload.");
		} else {			
			Long intf_id = (long) -1;
			StringBuilder result = new StringBuilder();
			String fileName = null;
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// maximum size that will be stored in memory
				factory.setSizeThreshold(maxMemSize);

				// Location to save data that is larger than maxMemSize.
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);

				// sets maximum size of upload file
				upload.setFileSizeMax(maxFileSize);

				// sets maximum size of request (include file + form data)
				upload.setSizeMax(maxFileSize);

				// Parse the request to get file items.
				@SuppressWarnings("rawtypes")
				List fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				@SuppressWarnings("rawtypes")
				Iterator i = fileItems.iterator();

				// constructs the folder where uploaded file will be stored
				//String uploadFolder = getServletContext().getRealPath("") + File.separator;
				FileItem fi = null;
				while (i.hasNext()) {
					fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						result.append("<tr><td>File:</td><td>"+fi.getName()+"</td></tr>");
						fileName = getFileName(intf_id);
						if (fileName==null)
							throw new MessageException("Failed to get file interface.");
											
						file = new File(fileName);
						fi.write(file);
						
						result.append("<tr><td> has been saved as:</td><td> "+fileName);
						result.append("</td></tr>");
						
						
					} else {
						if ("fileIntf_list".equals(fi.getFieldName())) {
							intf_id = Long.valueOf(fi.getString());
						} 
					}
					
				}
				request.setAttribute("message", result.toString());

			} catch (Exception ex) {
				log.error("Failed to save file", ex);
				response.sendError(HttpServletResponse.SC_BAD_REQUEST,
						ex.getMessage());
			}
		}
		request.getRequestDispatcher("/jsp/uploadDone.jsp").forward(request,
				response);
	}

	private String getFileName(Long intf_id) {
		// check if interface id is fetched
		if (intf_id < 0)
			throw new MessageException("Failed to get interface");
		
		String result = null;
		
		File_Interface fs = (File_Interface) CommonDao.loadById(File_Interface.class,intf_id);
		result = fs.getDirectory();
		
		Map<String, String> fileName = new HashMap<String, String>();
		fileName.put(fs.getName(), fs.getFile_name_rule());
		TemplateMessageCreator creator = new TemplateMessageCreator(fileName);
		
		result = result +File.separator+ creator.buildString(fs.getName());
		return result;
	}
