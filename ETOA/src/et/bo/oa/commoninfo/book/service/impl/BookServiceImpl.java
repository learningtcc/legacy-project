/**
 * 	@(#)BookServiceImpl.java   Aug 31, 2006 6:13:07 PM
 *	 。 
 *	 
 */
package et.bo.oa.commoninfo.book.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import et.bo.oa.commoninfo.book.service.BookService;
import et.po.BookBorrowInfo;
import et.po.BookInfo;
import et.po.EmployeeInfo;
import excellence.common.key.KeyService;
import excellence.common.page.PageInfo;
import excellence.common.util.time.TimeUtil;
import excellence.framework.base.dao.BaseDAO;
import excellence.framework.base.dto.IBaseDTO;
import excellence.framework.base.dto.impl.DynaBeanDTO;

/**
 * @author zhang
 * @version Aug 31, 2006
 * @see
 */
public class BookServiceImpl implements BookService {

	private BaseDAO dao = null;

	private KeyService ks = null;

	// 已借出
	private String BOOK_HAS_BORROWED = "1";

	// 未借出
	private String BOOK_NOT_BORROWED = "2";

	// 已丢失
	private String HAS_LOSE = "3";

	private int BOOK_NUM = 0;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	public KeyService getKs() {
		return ks;
	}

	public void setKs(KeyService ks) {
		this.ks = ks;
	}

	private BookInfo createBookInfo(IBaseDTO dto) {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setId(ks.getNext("email_box"));
		bookInfo.setBookName(dto.get("bookName").toString());
		bookInfo.setBookAuthor(dto.get("bookAuthor").toString());
		bookInfo.setBookConcern(dto.get("bookConcern").toString());
		bookInfo.setBookNum(dto.get("bookNum").toString());
		bookInfo.setIntroduce(dto.get("introduce").toString());
		bookInfo.setBookPrice(dto.get("bookPrice").toString());
		bookInfo.setBuyTime(TimeUtil.getTimeByStr(
				dto.get("buyTime").toString(), "yyyy-MM-dd"));
		bookInfo.setNoteTime(TimeUtil.getTimeByStr(dto.get("noteTime")
				.toString(), "yyyy-MM-dd"));
		bookInfo.setBorrowState(BOOK_NOT_BORROWED);
		bookInfo.setBookType(dto.get("bookType").toString());
		bookInfo.setRemark(dto.get("remark").toString());
		return bookInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see et.bo.oa.commoninfo.book.service.BookService#addBookInfo(excellence.framework.base.dto.IBaseDTO)
	 */
	public boolean addBookInfo(IBaseDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		dao.saveEntity(createBookInfo(dto));
		flag = true;
		return flag;
	}

	private BookBorrowInfo createBookBorrowInfo(IBaseDTO dto) {
		BookBorrowInfo bookBorrowInfo = new BookBorrowInfo();
		bookBorrowInfo.setId(ks.getNext("book_borrow_info"));
		BookInfo bookInfo = (BookInfo) dao.loadEntity(BookInfo.class, dto.get(
				"id").toString());
		bookBorrowInfo.setBookInfo(bookInfo);
		bookBorrowInfo.setBookUser(dto.get("bookUser").toString());
		bookBorrowInfo.setBorrowTime(TimeUtil.getTimeByStr(dto
				.get("borrowTime").toString(), "yyyy-MM-dd"));
		return bookBorrowInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see et.bo.oa.commoninfo.book.service.BookService#addBorrowInfo(excellence.framework.base.dto.IBaseDTO)
	 */
	public boolean addBorrowInfo(IBaseDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		dao.saveEntity(createBookBorrowInfo(dto));
		BookInfo bookInfo = (BookInfo) dao.loadEntity(BookInfo.class, dto.get(
				"id").toString());
		bookInfo.setBorrowState(BOOK_HAS_BORROWED);
		dao.updateEntity(bookInfo);
		flag = true;
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see et.bo.oa.commoninfo.book.service.BookService#addReturnInfo(excellence.framework.base.dto.IBaseDTO)
	 */
	public boolean addReturnInfo(IBaseDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = false;

		BookSearch bookSearch = new BookSearch();
		BookInfo bookInfo = (BookInfo) dao.loadEntity(BookInfo.class, dto.get(
				"id").toString());
		Object[] result = (Object[]) dao.findEntity(bookSearch
				.searchBookBorrowInfo(dto, bookInfo));
		for (int i = 0, size = result.length; i < size; i++) {
			BookBorrowInfo bookBorrowInfo = (BookBorrowInfo) result[i];
			bookBorrowInfo.setReturnTime(TimeUtil.getTimeByStr(dto.get(
					"returnTime").toString(), "yyyy-MM-dd"));
			dao.updateEntity(bookBorrowInfo);
		}

		bookInfo.setBorrowState(BOOK_NOT_BORROWED);
		dao.updateEntity(bookInfo);
		flag = true;
		return flag;
	}

	public boolean addReBorrowInfo(IBaseDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = false;

		BookSearch bookSearch = new BookSearch();
		BookInfo bookInfo = (BookInfo) dao.loadEntity(BookInfo.class, dto.get(
				"id").toString());
		Object[] result = (Object[]) dao.findEntity(bookSearch
				.searchBookBorrowInfo(dto, bookInfo));
		for (int i = 0, size = result.length; i < size; i++) {
			BookBorrowInfo bookBorrowInfo = (BookBorrowInfo) result[i];
			bookBorrowInfo.setReturnTime(TimeUtil.getNowTime());
			dao.updateEntity(bookBorrowInfo);
		}

		dao.saveEntity(createBookBorrowInfo(dto));

		bookInfo.setBorrowState(BOOK_HAS_BORROWED);
		dao.updateEntity(bookInfo);
		flag = true;
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see et.bo.oa.commoninfo.book.service.BookService#delBookInfo(excellence.framework.base.dto.IBaseDTO)
	 */
	public boolean delBookInfo(IBaseDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		BookInfo bookInfo = (BookInfo) dao.loadEntity(BookInfo.class, dto.get(
				"id").toString());
		dao.removeEntity(bookInfo);
		flag = true;
		return flag;
	}

	/**
	 * 更新信息
	 * 
	 * @param
	 * @version Aug 31, 2006
	 * @return
	 */
	private BookInfo upBookInfo(IBaseDTO dto) {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setId(dto.get("id").toString());
		bookInfo.setBookName(dto.get("bookName").toString());
		bookInfo.setBookAuthor(dto.get("bookAuthor").toString());
		bookInfo.setBookConcern(dto.get("bookConcern").toString());
		bookInfo.setBookNum(dto.get("bookNum").toString());
		bookInfo.setIntroduce(dto.get("introduce").toString());
		bookInfo.setBookPrice(dto.get("bookPrice").toString());
		bookInfo.setBuyTime(TimeUtil.getTimeByStr(
				dto.get("buyTime").toString(), "yyyy-MM-dd"));
		bookInfo.setNoteTime(TimeUtil.getTimeByStr(dto.get("noteTime")
				.toString(), "yyyy-MM-dd"));
		bookInfo.setBookType(dto.get("bookType").toString());
		bookInfo.setRemark(dto.get("remark").toString());
		return bookInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see et.bo.oa.commoninfo.book.service.BookService#updateBookInfo(excellence.framework.base.dto.IBaseDTO)
	 */
	public boolean updateBookInfo(IBaseDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		dao.updateEntity(upBookInfo(dto));
		flag = true;
		return flag;
	}

	public IBaseDTO getBookInfo(String id) {
		// TODO Auto-generated method stub
		IBaseDTO dto = new DynaBeanDTO();
		BookInfo bookInfo = (BookInfo) dao.loadEntity(BookInfo.class, id);
		dto.set("id", bookInfo.getId());
		dto.set("bookName", bookInfo.getBookName());
		dto.set("bookAuthor", bookInfo.getBookAuthor());
		dto.set("bookConcern", bookInfo.getBookConcern());
		dto.set("bookNum", bookInfo.getBookNum());
		dto.set("introduce", bookInfo.getIntroduce());
		dto.set("bookPrice", bookInfo.getBookPrice());
		dto.set("buyTime", TimeUtil.getTheTimeStr(bookInfo.getBuyTime()));
		dto.set("noteTime", TimeUtil.getTheTimeStr(bookInfo.getNoteTime()));
		dto.set("borrowState", bookInfo.getBorrowState());
		dto.set("bookType", bookInfo.getBookType());
		dto.set("remark", bookInfo.getRemark());
		return dto;
	}

	public boolean loseBookInfo(IBaseDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		BookInfo bookInfo = (BookInfo) dao.loadEntity(BookInfo.class, dto.get(
				"id").toString());
		bookInfo.setBorrowState(HAS_LOSE);
		dao.updateEntity(bookInfo);
		flag = true;
		return flag;
	}

	public List bookIndex(IBaseDTO dto, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		BookSearch bookSearch = new BookSearch();
		Object[] result = (Object[]) dao.findEntity(bookSearch.searchBookList(
				dto, pageInfo));
		int s = dao.findEntitySize(bookSearch.searchBookList(dto, pageInfo));
		BOOK_NUM = s;
		for (int i = 0, size = result.length; i < size; i++) {
			BookInfo bookInfo = (BookInfo) result[i];
			DynaBeanDTO dbd = new DynaBeanDTO();
			dbd.set("id", bookInfo.getId());
			dbd.set("bookName", bookInfo.getBookName());
			dbd.set("bookAuthor", bookInfo.getBookAuthor());
			dbd.set("bookConcern", bookInfo.getBookConcern());
			String borrowState = bookInfo.getBorrowState();
			// 图书状态
			String bookState = "";
			if (borrowState.equals(BOOK_NOT_BORROWED)) {
				bookState = "未借出";
			}
			if (borrowState.equals(BOOK_HAS_BORROWED)) {
				bookState = "已借出";
			}
			if (borrowState.equals(HAS_LOSE)) {
				bookState = "丢失";
			}
			dbd.set("borrowState", bookState);
			l.add(dbd);
		}
		return l;
	}

	public int getBookSize() {
		// TODO Auto-generated method stub
		return BOOK_NUM;
	}

	public List<LabelValueBean> getEmployeeList() {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		BookSearch bookSearch = new BookSearch();
		Object[] result = (Object[]) dao.findEntity(bookSearch
				.searchEmployeeInfo());
		for (int i = 0, size = result.length; i < size; i++) {
			EmployeeInfo employeeInfo = (EmployeeInfo) result[i];
			l.add(new LabelValueBean(employeeInfo.getName(), employeeInfo
					.getId()));
		}
		return l;
	}

	public List getBorrowInfo(String id) {
		// TODO Auto-generated method stub
		String borrowUserName = "";
		List l = new ArrayList();
		BookSearch bookSearch = new BookSearch();
		BookInfo bookInfo = (BookInfo)dao.loadEntity(BookInfo.class, id);
		
		Object[] result = (Object[]) dao.findEntity(bookSearch
				.searchBorrowUser(bookInfo));
		for (int i = 0, size = result.length; i < size; i++) {
			BookBorrowInfo bookBorrowInfo = (BookBorrowInfo)result[i];
			borrowUserName = bookBorrowInfo.getBookUser();
			EmployeeInfo employeeInfo = (EmployeeInfo)dao.loadEntity(EmployeeInfo.class, borrowUserName);
			l.add(new LabelValueBean(employeeInfo.getName(), employeeInfo
					.getId()));
		}
		return l;
	}

}
