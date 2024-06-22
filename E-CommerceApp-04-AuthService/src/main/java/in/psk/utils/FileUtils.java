package in.psk.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	public static String saveFile(String fileName, MultipartFile file) throws IOException {
		// uploading file into this below filepath(user-images)
		Path uploadPath = Paths.get("User-Images");
		// if path is not there
		if (!Files.exists(uploadPath)) {
			// creating path
			Files.createDirectories(uploadPath);

		}
		//uploaded filename:facebook.png
		//file code:jsfl756_facebook.png 
		// generating random filecode
		String fileCode = RandomStringUtils.randomAlphanumeric(9);
		Path filePath = uploadPath.resolve(fileCode + "_" + fileName);
		// copying filepath to file and if file is already is there then replace the
		// file
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		return fileCode;
		//binary data will be stored in normal file systems or amazon s3  service
		//binary data will not stored in database 
		//this filecode will be stored in database
	}

}
