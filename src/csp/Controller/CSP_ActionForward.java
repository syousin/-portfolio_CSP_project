package csp.Controller;

public class CSP_ActionForward {
	private String path;
	private boolean redirect;
	
	public CSP_ActionForward() {
		
	}
	
	public CSP_ActionForward(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
