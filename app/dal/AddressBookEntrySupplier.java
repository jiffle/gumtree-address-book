/** File:       AddressEntrySupplier.java
 *  Created by: davidhamilton
 *          on: 16 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package dal;

import pojo.AddressBookEntry;

import com.google.common.base.Supplier;
import com.google.common.collect.FluentIterable;
import com.google.inject.ImplementedBy;

/** Allows a results of the address book to be retrieved
 * Currently only implemented by AddressBookLoader
 */
@ImplementedBy(AddressBookLoader.class)
public interface AddressBookEntrySupplier extends Supplier<FluentIterable<AddressBookEntry>> {

}
