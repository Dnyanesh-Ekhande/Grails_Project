package managehdd

class Folder {

    String name
    int fileCount

    static belongsTo = [drive: Drive]
    static hasMany = [files: File]
    static constraints = {
    }

    static saveFolderData(def jsonObject) {

        return new Folder(
                name: jsonObject.name, fileCount: jsonObject.fileCount
        )
    }
}
