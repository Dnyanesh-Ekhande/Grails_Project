package managehdd

import grails.transaction.Transactional

@Transactional
/**
 * Class having saveData method to save data to database
 */
class InsertFileDataService {

    /**
     * Method takes object of Folder and saves it to database
     * @param input : Folder Object
     */
    void saveData(Folder input) {

        input.save(flush: true)   // Call to save() method

    } // End: void saveData(Folder input) {
} // End: class InsertFileDataService {
