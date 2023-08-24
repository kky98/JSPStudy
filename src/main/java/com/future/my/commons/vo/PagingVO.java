package com.future.my.commons.vo;

public class PagingVO {
	    // 입력받는 데이터
		private int curPage = 1; // 현재 페이지 번호
		private int rowSizePerPage = 10; // 한 페이지당 레코드 수 기본10
		private int pageSize = 10; // 페이지 리스트에서 보여줄 페이지 갯수 이거는 보통 10 or 5 안 변함
		private int totalRowCount; // 총 레코드 건수

		// 입력받는 데이터를 통해 계산되는 값
		private int firstRow; // 시작 레크드 번호
		private int lastRow; // 마지막 레크드 번호
		private int totalPageCount; // 총 페이지 건수
		private int firstPage; // 페이지 리스트에서 시작 페이지 번호
		private int lastPage; // 페이지 리스트에서 마지막 페이지 번호

		// page계산
		public void pageSetting() {
			firstRow = (curPage - 1) * rowSizePerPage + 1;
			lastRow = firstRow + rowSizePerPage - 1;
			totalPageCount = (totalRowCount - 1) / rowSizePerPage + 1;
			firstPage = ((curPage - 1) / pageSize) * pageSize + 1;
			lastPage = firstPage + pageSize - 1;
			if (lastPage > totalPageCount) {
				lastPage = totalPageCount;
			}
		}

		public int getCurPage() {
			return curPage;
		}

		public void setCurPage(int curPage) {
			this.curPage = curPage;
		}

		public int getRowSizePerPage() {
			return rowSizePerPage;
		}

		public void setRowSizePerPage(int rowSizePerPage) {
			this.rowSizePerPage = rowSizePerPage;
		}

		public int getFirstRow() {
			return firstRow;
		}

		public void setFirstRow(int firstRow) {
			this.firstRow = firstRow;
		}

		public int getLastRow() {
			return lastRow;
		}

		public void setLastRow(int lastRow) {
			this.lastRow = lastRow;
		}

		public int getTotalRowCount() {
			return totalRowCount;
		}

		public void setTotalRowCount(int totalRowCount) {
			this.totalRowCount = totalRowCount;
		}

		public int getTotalPageCount() {
			return totalPageCount;
		}

		public void setTotalPageCount(int totalPageCount) {
			this.totalPageCount = totalPageCount;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getFirstPage() {
			return firstPage;
		}

		public void setFirstPage(int firstPage) {
			this.firstPage = firstPage;
		}

		public int getLastPage() {
			return lastPage;
		}

		public void setLastPage(int lastPage) {
			this.lastPage = lastPage;
		}
}
