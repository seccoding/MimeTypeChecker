package io.github.seccoding.web.mimetype;

public class ExtensionFilterTest {

	public static void main(String[] args) {
		
		ExtensionFilter filter = ExtensionFilterFactory.getFilter(ExtFilter.COMPARE_EXTENSION);
		boolean isWrite = filter.doFilter("D:\\해썸\\HAESOME_160114.pdf", "pdf");
		System.out.println(isWrite);
		
		filter = ExtensionFilterFactory.getFilter(ExtFilter.JMIME_MAGIC);
		isWrite = filter.doFilter("D:\\해썸\\HAESOME_160114.pdf", "application/pdf");
		System.out.println(isWrite);
		
		filter = ExtensionFilterFactory.getFilter(ExtFilter.APACHE_TIKA);
		isWrite = filter.doFilter("D:\\해썸\\HAESOME_160114.pdf", "application/pdf");
		System.out.println(isWrite);
	}
	
}
