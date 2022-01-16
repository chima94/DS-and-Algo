package leetcode


fun main(){
    val list = arrayListOf(
        arrayOf(0, 1),
        arrayOf(0, 2),
        arrayOf(1, 3),
        arrayOf(1, 4),
        arrayOf(3, 4)

    )
    println(courseSchedule(5, list))
}


fun courseSchedule(numCourses: Int, prerequisites: ArrayList<Array<Int>>): Boolean{

    val hashMap = HashMap<Int, ArrayList<Int>>()
    val hashSet = HashSet<Int>()

    for (i in 0 until numCourses){
        hashMap[i] = ArrayList()
    }


    var i = 0
    while(i < prerequisites.size){
        hashMap[prerequisites[i][0]]?.add(prerequisites[i][1])
        i++
    }


    fun dfs(crs: Int) : Boolean{
        if(crs in hashSet){
            return false
        }
        if(hashMap[crs]?.isEmpty() == true){
            return true
        }
        hashSet.add(crs)
        hashMap[crs]?.forEach {
            if (!dfs(it)) return false
        }
        hashSet.remove(crs)
        hashMap[crs] = ArrayList()
        return true
    }
    for(crs in 0 until numCourses){
       if(!dfs(crs)) return false

    }
    return true
}