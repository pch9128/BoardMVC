package kr.itedu.boardmvc;

public class ActionForward {
	private String path;
	private boolean isredirect;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isredirect;
	}
	public void setRedirect(boolean redirect) {
		this.isredirect = redirect;
	}
	


}
