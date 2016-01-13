package managehdd

import grails.transaction.Transactional

@Transactional
/**
 * Class having saveData method to save data to database
 */
class InsertFolderDataService {

    /**
     * Method takes object of Drive and saves it to database
     * @param input
     */
    void saveData(Drive input) {

        input.save(flush: true)  // Call to save() method

    } // End:  void saveData(Drive input) {
} // End: class InsertFolderDataService {
