package managehdd

import grails.util.Holders

/**
 * Understanding GORM with association by implementing basic Hard disk storage structure
 */

class DriveController {   // Controller

    // Including all required services
    def insertHardDiskService
    def insertFileDataService
    def insertFolderDataService

    def index() {  // Default method/action which will be invoked once we execute DriveController

        println Holders.config.getProperty("temp")
        HardDisk hardDisk = new HardDisk(companyName: 'Scandisk', capacityInGB: 200)
        // Creating HardDisk record using Named Constructor
        Drive[] drive = new Drive[4]        // List of object for Drive

        def drives = []           // list of Drives
        drives.push(name: 'C')
        drives.push(name: 'D')
        drives.push(name: 'E')
        drives.push(name: 'F')

        // Converting list of drives into list of objects of Drive
        drives.eachWithIndex { Object entry, int index ->

            drive[index] = (Drive) entry      // Cast each element in list of drives into Drive object
            Drive drive1 = loadFolders(drive[index])    // Passing each object of Drive to method which loads folders in it
            hardDisk.addToDrives(drive1)         // Add all drives having folders added  to Hard Disk

        } // End:drives.eachWithIndex { Object entry, int index ->

        insertHardDiskService.saveData(hardDisk)   // Call to service to save hard disk data
//        render "HDD Management"

    } // End: def index() {

    /**
     * Method to load number of folders in drive
     * @param drive Drive Object
     * @return Drive object with folders loaded in it
     */
    Drive loadFolders(Drive drive) {

        // Create list of Folders
        def folders = []
        folders.push(name: 'Movie', fileCount: 5)
        folders.push(name: 'Songs', fileCount: 4)
        folders.push(name: 'Games', fileCount: 50)
        folders.push(name: 'Images', fileCount: 44)

        // Declare List of object of Folder with required size
        Folder[] folders1 = new Folder[folders.size()]

        folders.eachWithIndex { Object entry, int index ->   // Converting list of folders into list of objects of Folder

            folders1[index] = (Folder) entry                 // Cast each element in list of folders into Folder object
            Folder folder = loadFiles(folders1[index])    // Passing each object of Folder to method which loads files in it
            drive.addToFolders(folder)                        // Relate drive to all folders making relation one(Drive) - Many(Folders)

        } // End: folders.eachWithIndex { Object entry, int index ->

        insertFolderDataService.saveData(drive)               // Call service to save drive data
        return drive                                          // return drive
    } // End: Drive loadFolders(Drive drive) {

    /**
     * Method to load number of files in Folder
     *
     * @param folder : Folder object
     *
     * @return : Folder object with files loaded in it
     */
    Folder loadFiles(Folder folder) {

        // Create list of Files
        def files = []
        files.push(name: 'Sarkar.jpg')
        files.push(name: 'Lovestory.flv')
        files.push(name: 'Dosti.flv')
        files.push(name: 'Isqk.jpg')

        File[] files1 = new File[files.size()]             // Declare List of object of Files with required size

        files.eachWithIndex { Object entry, int index ->   // Converting list of files into list of objects of Files

            files1[index] = (File) entry                   // Cast each element in list of files into File object
            folder.addToFiles(files1[index])              // Relate folder to all files making relation one(Folder) - Many(Files)

        } // End: files.eachWithIndex { Object entry, int index ->

        insertFileDataService.saveData(folder)            // Call service to save Folder data
        return folder                                     // return Folder
    } // End:  Folder loadFiles(Folder folder) {

    /**
     * Method to delete record
     * @return : Deleted record
     */
//    def deleteRecord() {
//
//        def drive = Drive.get(2)
//
//        def folder = Folder.findByDriveAndName(drive, 'Songs')
//
//        folder.delete()
//
//    }

}
