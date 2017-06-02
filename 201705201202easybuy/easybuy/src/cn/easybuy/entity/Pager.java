package cn.easybuy.entity;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable {
	private int pageNo;// 页码
	private int pageSize;// 每页数量
	private int totalCount;//总数量
	
}
