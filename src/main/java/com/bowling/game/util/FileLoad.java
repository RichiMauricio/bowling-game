/**
 * 
 */
package com.bowling.game.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Richard
 *
 */
@Component
@Lazy
public class FileLoad implements IFileLoad {

	@Override
	public List<String> loadFile(Path filePath) {
		List<String> archivoLst = new ArrayList<>();
		try {
			archivoLst = Files.lines(filePath).collect(Collectors.toList());;
			return archivoLst;
		} catch (IOException e) {
			return Collections.emptyList();
		}
	}

	// Validar el archivo
}
