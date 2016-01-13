package managehdd

import grails.transaction.Transactional

@Transactional
/**
 * Class having saveData method to save data to database
 */
class InsertHardDiskService {

    /**
     * Method takes object of HardDisk and saves it to database
     * @param input : HardDisk Object
     */
    void saveData(HardDisk input) {

        input.save(flush: true)  // Call to save() method

    } // End: void saveData(HardDisk input) {
} // End: class InsertDataService {
