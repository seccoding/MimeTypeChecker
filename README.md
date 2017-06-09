# MimeTypeChecker
Java에서 업로드된 파일의 MimeType을 체크하는 유틸리티

## 사용 방법
### maven dependency에 MimeTypeChecker-1.0.0.jar 파일을 추가할 경우
1. MimeTypeChecker-1.0.0.jar파일을 C:\에 복사합니다.
1. Maven 명령어를 이용해 .m2 Repository 에 MimeTypeChecker-1.0.0.jar 를 설치(저장)합니다.
1. <pre>mvn install:install-file -Dfile=C:\MimeTypeChecker-1.0.0.jar -DgroupId=io.github.seccoding -DartifactId=MimeTypeChecker -Dversion=1.0.0 -Dpackaging=jar</pre>
1. 본인의 Project/pom.xml 에 dependency를 추가합니다.
1. <pre>
	&lt;dependency&gt;
		&lt;groupId&gt;io.github.seccoding&lt;/groupId&gt;
		&lt;artifactId&gt;MimeTypeChecker&lt;/artifactId&gt;
		&lt;version&gt;1.0.0&lt;/version&gt;
	&lt;/dependency&gt;
</pre>

### 소스코드를 사용할 경우
1. Clone or Download 를 클릭합니다.
1. Download ZIP 을 클릭해 소스코드를 다운로드 받습니다.
1. MimeTypeChecker/pom.xml의 dependencies를 본인의 Project/pom.xml 에 붙혀넣습니다.
1. MimeTypeChecker/src 이하의 자바코드를 본인의 Project에 붙혀넣습니다. 
---
## MimeTypeChecker 사용하기
### MimeTypeChecker는 3가지 확장자 체크를 지원합니다.
1. COMPARE_EXTENSION
1. <pre>단순히 확장자만 체크합니다. Mimetype은 체크하지 않습니다.</pre>
1. JMIME_MAGIC
1. <pre>Mimetype을 체크합니다. 업로드된 파일의 Byte를 모두 읽어 처리하기 때문에 속도가 느립니다. 
	단, 라이브러리의 용량이 작습니다.</pre>
1. APACHE_TIKA
1. <pre>Mimetype을 체크합니다. 업로드된 파일의 Mimetype만 체크하기 때문에 속도가 빠릅니다. 
	단, 라이브러리의 용량이 큽니다.</pre>

---

<pre>
import io.github.seccoding.web.mimetype.ExtensionFilterFactory;
import io.github.seccoding.web.mimetype.ExtFilter;

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
</pre>