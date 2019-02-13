package snmaddula.quicktrick.ng.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class FileDownloadController {

	@GetMapping("/xls")
	public void downloadXLS(String fileName, HttpServletResponse res) throws IOException, URISyntaxException {
		byte[] file = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("alpha.xls").toURI()));
		res.setHeader("Content-Disposition", "attachment; filename=alpha.xls");
		res.getOutputStream().write(file);
	}

	@GetMapping("/xlsx")
	public void downloadXLSX(String fileName, HttpServletResponse res) throws IOException, URISyntaxException {
		byte[] file = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("alpha.xlsx").toURI()));
		res.setHeader("Content-Disposition", "attachment; filename=alpha.xlsx");
		res.getOutputStream().write(file);
	}

	@GetMapping("/pdf")
	public void downloadPDF(String fileName, HttpServletResponse res) throws IOException, URISyntaxException {
		byte[] file = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("alpha.pdf").toURI()));
		res.setHeader("Content-Disposition", "attachment; filename=alpha.pdf");
		res.getOutputStream().write(file);
	}

}
