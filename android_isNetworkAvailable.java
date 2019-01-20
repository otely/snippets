private boolean isOnline(Context ctx) {
    	ConnectivityManager connectivityManager =
    	(ConnectivityManager)
    	ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo networkInfo =
    	connectivityManager.getActiveNetworkInfo();
    	return (networkInfo != null &&
    	networkInfo.isConnected());
    	}

private boolean isNetworkAvailable(Context ctx)   {
    	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    	StrictMode.setThreadPolicy(policy);
  	    if (isOnline(ctx)) {
  	    	
  	    	if (CheckingUrls("http://www.google.com")) {
  	    		return true;
  	    	} else return false;
  	    		
           /*     
            try {
                	URL url = new URL("http://www.google.com");
                	HttpURLConnection urlc = (HttpURLConnection) url.openConnection();  
                	urlc.setConnectTimeout(4000);
                	urlc.connect();
                
                if (urlc.getResponseCode() == 200) {
                	//urlc.disconnect();
                    return true;
                } else {
                	     //urlc.disconnect();
                       
                }
               
            } catch (MalformedURLException e1) {
                // TODO Auto-generated catch block            	
                e1.printStackTrace();
            } catch (SocketTimeoutException e2) {  
            	e2.printStackTrace();
            	Log.e("com.swf.reader", "exception", e2);
            } catch (IOException e3) {
                // TODO Auto-generated catch block
                e3.printStackTrace();
            } */
        }
  	    
        return false;
    }
    
    private boolean CheckingUrls(String url) {
    	// initilize the default HTTP client object
    	final DefaultHttpClient client = new DefaultHttpClient();
    	//forming a HttpGet request
    	final HttpGet getRequest = new HttpGet(url);
    	try {
    		 HttpResponse response = client.execute(getRequest);
        	//check 200 OK for success
        	final int statusCode = response.getStatusLine().getStatusCode();
    	    if (statusCode != HttpStatus.SC_OK) {
//    	    	Log.w("com.apps", "Error " + statusCode + url);
    	    	return false;
    	    } else { getRequest.abort();
    	    	     return true;
    	    }
    	    
    	   /* final HttpEntity entity = response.getEntity();
    	    
    	    if (entity != null) {
    	InputStream inputStream = null;
    	try {
    	// getting contents from the stream
    	inputStream = entity.getContent();
    	// decoding stream data back into image Bitmap that android
    	understands
    	final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
    	return bitmap;
    	} finally {
    	if (inputStream != null) {
    	inputStream.close();
    	}
    	entity.consumeContent();
    	}
    	}*/
    	} catch (Exception e) {
    	// You Could provide a more explicit error message for IOException
    	getRequest.abort();
    	e.printStackTrace();    	
    	Log.e("com.apps", "Something went wrong" +
    	 url + e.toString());
    	}
    	return false;
    	}
