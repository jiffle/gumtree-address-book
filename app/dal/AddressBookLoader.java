/** File:       AddressBookLoader.java
 *  Created by: davidhamilton
 *          on: 16 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package dal;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import play.vfs.VirtualFile;
import pojo.AddressBookEntry;

import com.google.common.collect.FluentIterable;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import common.AppRuntimeException;

/** Implementation that loads address book and supplies stream of entries.
 */
@Singleton
public class AddressBookLoader implements AddressBookEntrySupplier {
private static final String ADDRESS_BOOK_FILE_NAME = "AddressBook";		// replace with properties as required
private static final Charset DEFAULT_CHARSET = Charset.forName( "UTF-8");
@Inject
private EntryLineProcessor entryLineProcessor;

	/* (non-Javadoc)
	 * @see com.google.common.base.Supplier#get()
	 */
	@Override
	public FluentIterable< AddressBookEntry> get() {
		// TODO not thread-safe: need to cache & update
		try {
			VirtualFile vf = VirtualFile.fromRelativePath( ADDRESS_BOOK_FILE_NAME);
			File realFile = vf.getRealFile();
			return Files.readLines( realFile, DEFAULT_CHARSET, entryLineProcessor);
		}
		catch( IOException e) {
			throw new AppRuntimeException( "Error reading address book file", e);
		}
	}
}
