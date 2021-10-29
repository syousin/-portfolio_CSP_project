package csp.service;

public class Board_Service_Paging {
	private int curpage = 0;
	private int curpage_start = 0;
	private int curpage_last = 0;
	private int curpage_total = 0;
	private int block_begin = 0;
	private int block_end = 0;
	
	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getCurpage_start() {
		return curpage_start;
	}

	public void setCurpage_start(int curpage_start) {
		this.curpage_start = curpage_start;
	}

	public int getCurpage_last() {
		return curpage_last;
	}

	public void setCurpage_last(int curpage_last) {
		this.curpage_last = curpage_last;
	}

	public int getCurpage_total() {
		return curpage_total;
	}

	public void setCurpage_total(int curpage_total) {
		this.curpage_total = curpage_total;
	}

	public int getBlock_begin() {
		return block_begin;
	}

	public void setBlock_begin(int block_begin) {
		this.block_begin = block_begin;
	}

	public int getBlock_end() {
		return block_end;
	}

	public void setBlock_end(int block_end) {
		this.block_end = block_end;
	}
}
