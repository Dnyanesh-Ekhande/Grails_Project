package managehdd

class File {

    String name
    static belongsTo = [folder: Folder]

    static constraints = {
    }
}
