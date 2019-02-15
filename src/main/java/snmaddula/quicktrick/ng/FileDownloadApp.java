package snmaddula.quicktrick.ng;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FileDownloadApp {

	@GetMapping("/download")
	public void downloadFile(String fileName, HttpServletResponse res) throws Exception {
		res.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		res.getOutputStream().write(contentOf(fileName));
	}

	private byte[] contentOf(String fileName) throws Exception {
		return readAllBytes(get(getClass().getClassLoader().getResource(fileName).toURI()));
	}

	public static void main(String[] args) {
		SpringApplication.run(FileDownloadApp.class, args);
	}
}
