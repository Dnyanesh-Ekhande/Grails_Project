package managehdd

class HardDisk {

    String companyName
    Integer capacityInGB

    static hasMany = [drives: Drive]
    static constraints = {
    }
}
