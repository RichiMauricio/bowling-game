/**
 * 
 */
package com.bowling.game.util;

import java.nio.file.Path;
import java.util.List;

/**
 * @author Richard
 *
 */
public interface IFileLoad {

	/**
	 * Cargar el archivo segun la ruta.
	 * 
	 * @param filePath
	 * @return
	 */
	List<String> loadFile(Path filePath);
}
