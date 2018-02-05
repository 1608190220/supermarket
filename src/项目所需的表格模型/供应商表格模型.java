package 项目所需的表格模型;

/*
 * 供应商 表格模型
 * 显示表格列名
 * 2017 12 9
 */

public class 供应商表格模型 extends javax.swing.table.DefaultTableModel { // 继承 表格存储模型类
	Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class };
	boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, false };

	public 供应商表格模型() {
		// 直接调用父类 DefaultTableModel 构造方法，创建一个供应商表格
		super(new Object[][] {},
				new String[] { "编号", "客户名称", "地址", "联系人", "联系电话", "传真", "邮编", "银行账号", "网址", "Emall地址", "备注" });
	}
}
