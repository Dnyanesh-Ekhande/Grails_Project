package managehdd

class Drive {

    String name

    static belongsTo = [hardDisk: HardDisk]
    static hasMany = [folders: Folder]
    static constraints = {
    }

    /**
     *
     * @param jsonObject
     * @return
     */
    static saveDriveData(def jsonObject) {

        return new Drive(
                name: jsonObject.name
        )
    }
}
