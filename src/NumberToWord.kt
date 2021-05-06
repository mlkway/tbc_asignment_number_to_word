 class NumberToWord(){

    private val oftenNumbers = mapOf(
        1 to "ერთი", 2 to "ორი", 3 to "სამი",
        4 to "ოთხი", 5 to "ხუთი",6 to "ექვსი",
        7 to "შვიდი", 8 to "რვა", 9 to "ცხრა",
        10 to "ათი",11 to "თერთმეტი", 12 to "თორმეტი",
        13 to "ცამეტი", 14 to "თოთხმეტი", 15 to "თხუთმეტი",
        16 to "თექვსმეტი", 17 to "ჩვიდმეტი", 18 to "თვრამეტი",
        19 to "ცხრამეტი", 20 to "ოცდა", 30 to "ოცდა",
        40 to "ორმოცდა",50 to "ორმოცდა", 60 to "სამოცდა",
        70 to "სამოცდა", 80 to "ოთხმოცდა", 90 to "ოთხმოცდა"
    )

    private val roundNumbers = mapOf(
        20 to "ოცი",30 to "ოცდაათი", 40 to "ორმოცი",
        50 to "ორმოცდაათი", 60 to "სამოცი", 70 to "სამოცდაათი",
        80 to "ოთხმოცი", 90 to "ოთხმოცდაათი", 100 to "ას",
        200 to "ორას",300 to "სამას",400 to "ოთხას",500 to "ხუთას",600 to "ექვსას",
        700 to "შვიდას",800 to "რვაას",900 to "ცხრაას",1000 to "ათას"
    )

    fun numberToWord(arg: Int):String?{
        if (arg in 100..1000){
            return  number_More_Than_100(arg)
        } else if(arg in 1..99){
            return numbers_Less_Than_100(arg)
        }else{
            return "Number Out Of Range"
        }
    }

    private fun number_More_Than_100(arg: Int):String?{
        if (roundNumbers[arg] != null){
            return roundNumbers[arg] + "ი"
        }else{
            return roundNumbers[arg - arg % 100] + numbers_Less_Than_100(arg % 100)
        }

    }

    private fun numbers_Less_Than_100(arg: Int): String? {


        if (roundNumbers[arg] != null){
            return roundNumbers[arg]

        } else if (oftenNumbers[arg] != null){

            return oftenNumbers[arg]
        } else {
            return oftenNumbers[arg - arg % 10] + oftenNumbers[arg % 20]
        }
    }
}