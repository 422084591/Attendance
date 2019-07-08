package model;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;

public class PageCount {
	private int maxPage;
	private int minPage=0;
	private int currentPage;
	private PageCount() {};
	private static final PageCount pageCount=new PageCount();	//单例模式
	public static PageCount getInstance() {
		return pageCount;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMinPage() {
		return minPage;
	}
	public void setMinPage(int minPage) {
		this.minPage = minPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
