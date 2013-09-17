package dal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pojo.AddressBookEntry;

import com.google.common.collect.FluentIterable;
import com.google.common.io.LineProcessor;
import com.google.inject.Singleton;

@Singleton
class EntryLineProcessor implements LineProcessor< FluentIterable< AddressBookEntry>> {
	final List<AddressBookEntry> entries = new ArrayList<AddressBookEntry>();
	
	@Override
	public boolean processLine( String line) {
		AddressBookEntry newEntry = createAddressBookEntry( line);
		if( newEntry != null) {
			entries.add( newEntry);
		}
		return true;
	}

	AddressBookEntry createAddressBookEntry( String line) {
		return AddressBookEntry.createFromCsvString( line);
	}

	@Override
	public FluentIterable< AddressBookEntry> getResult() {
		return FluentIterable.from( entries);
	}	
}