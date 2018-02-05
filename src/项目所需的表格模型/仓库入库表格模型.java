package 项目所需的表格模型;

/*
 * 仓库入库 表格 模型
 * 显示表格列名
 * 2017 12 10
 */

public class 仓库入库表格模型 extends javax.swing.table.DefaultTableModel {// 用class类建模，数组元素都是String类型
	Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class };
	boolean[] canEdit = new boolean[] { false, false, false, false, false };

	public 仓库入库表格模型() {
		// 直接调用父类 DefaultTableModel 构造方法，创建一个供应商表格
		super(new Object[][] {}, new String[] { "编号", "货品名称", "入库时间", "重量", "备注" });
	}
}
