package syr.project.homework_4
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
class MovieList {
    var movieList: List<MovieData> = Gson().fromJson(movies, Array<MovieData>::class.java).asList()
    var posterTable:MutableMap<String, Int> = mutableMapOf()
    init{
//        var movieList: ArrayList<MovieData> =movieList1 as ArrayList<MovieData>


        posterTable[movieList[0].title]=R.drawable.pci1aryw7oj2eyto2nmyekhhicp
        posterTable[movieList[1].title]=R.drawable.oyg9tl7fcrp4ez9vid6ukzwdndz
        posterTable[movieList[2].title]=R.drawable.riaoojrfvvhotyaogoi0wr7okse
        posterTable[movieList[3].title]=R.drawable.zgvbrulkupqpbwginedkjpyqum4
        posterTable[movieList[4].title]=R.drawable.t7xhp8sqtvanzecvn1oqrvwcxti
        posterTable[movieList[5].title]=R.drawable.q719jxxezooyaps6babgknononx
        posterTable[movieList[6].title]=R.drawable.hek3koduyrqk7fihpxsa6mt2zc3
        posterTable[movieList[7].title]=R.drawable.h1b7tw0t399vdjacwjh8m87469b
        posterTable[movieList[8].title]=R.drawable.velwphvmqeqkcxggneu8ymio52r
        posterTable[movieList[9].title]=R.drawable.plnlrtbuult0rh3xsjmpubiso3l
        for( i in movieList.indices){
            movieList[i].checked = false
        }

    }
}

    var movies = """        
[
    {
      "stars": "Melanie Zanetti, Giulio Berruti, James Andrew Fraser",
      "popularity": 15.593,
      "vote_count": 779,
      "video": false,
      "poster_path": "/pci1ArYW7oJ2eyTo2NMYEKHHiCP.jpg",
      "id": 724089,
      "adult": false,
      "backdrop_path": "/jtAI6OJIWLWiRItNSZoWjrsUtmi.jpg",
      "original_language": "en",
      "original_title": "Gabriel's Inferno Part II",
      "genre_ids": [
        10749
      ],
      "title": "Gabriel's Inferno Part II",
      "vote_average": 6,
      "overview": "Professor Gabriel Emerson finally learns the truth about Julia Mitchell's identity, but his realization comes a moment too late. Julia is done waiting for the well-respected Dante specialist to remember her and wants nothing more to do with him. Can Gabriel win back her heart before she finds love in another's arms?",
      "release_date": "2020-07-31"
    },
    {
      "stars": "Melanie Zanetti, Giulio Berruti, James Andrew Fraser",
      "popularity": 14.175,
      "vote_count": 1367,
      "video": false,
      "poster_path": "/oyG9TL7FcRP4EZ9Vid6uKzwdndz.jpg",
      "id": 696374,
      "adult": false,
      "backdrop_path": "/969BfPHGJcjg2aUv60g5uiiXFzf.jpg",
      "original_language": "en",
      "original_title": "Gabriel's Inferno",
      "genre_ids": [
        10749
      ],
      "title": "Gabriel's Inferno",
      "vote_average": 9,
      "overview": "An intriguing and sinful exploration of seduction, forbidden love, and redemption, Gabriel's Inferno is a captivating and wildly passionate tale of one man's escape from his own personal hell as he tries to earn the impossible--forgiveness and love.",
      "release_date": "2020-05-29"
    },
    {
      "stars": "Melanie Zanetti, Giulio Berruti, James Andrew Fraser",
      "popularity": 21.739,
      "vote_count": 205,
      "video": false,
      "poster_path": "/riAooJrFvVhotyaOgoI0WR7okSe.jpg",
      "id": 644479,
      "adult": false,
      "backdrop_path": "/8g1rUabKleLvovt0Sx6bXgWfC42.jpg",
      "original_language": "es",
      "original_title": "Dedicada a mi ex",
      "genre_ids": [
        35,
        18
      ],
      "title": "Dedicated to my ex",
      "vote_average": 8.9,
      "overview": "The film tells the story of Ariel, a 21-year-old who decides to form a rock band to compete for a prize of ten thousand dollars in a musical band contest, this as a last option when trying to get money to save their relationship and reunite with his ex-girlfriend, which breaks due to the trip she must make to Finland for an internship. Ariel with her friend Ortega, decides to make a casting to find the other members of the band, although they do not know nothing about music, thus forming a band with members that have diverse and opposite personalities.",
      "release_date": "2019-11-01"
    },
    {
      "stars": "Melanie Zanetti, Giulio Berruti, James Andrew Fraser",
      "popularity": 180.529,
      "vote_count": 372,
      "video": false,
      "poster_path": "/zGVbrulkupqpbwgiNedkJPyQum4.jpg",
      "id": 592350,
      "adult": false,
      "backdrop_path": "/9guoVF7zayiiUq5ulKQpt375VIy.jpg",
      "original_language": "ja",
      "original_title": "僕のヒーローアカデミア THE MOVIE ヒーローズ：ライジング",
      "genre_ids": [
        28,
        16
      ],
      "title": "My Hero Academia: Heroes Rising",
      "vote_average": 8.7,
      "overview": "Class 1-A visits Nabu Island where they finally get to do some real hero work. The place is so peaceful that it's more like a vacation … until they're attacked by a villain with an unfathomable Quirk! His power is eerily familiar, and it looks like Shigaraki had a hand in the plan. But with All Might retired and citizens' lives on the line, there's no time for questions. Deku and his friends are the next generation of heroes, and they're the island's only hope.",
      "release_date": "2019-12-20"
    },
    
    
   
    {
      "stars": "Melanie Zanetti, Giulio Berruti, James Andrew Fraser",
      "popularity": 37.749,
      "vote_count": 10289,
      "video": false,
      "poster_path": "/t7xhP8SQTVanzecvn1oQRVWCXTI.jpg",
      "id": 424,
      "adult": false,
      "backdrop_path": "/loRmRzQXZeqG78TqZuyvSlEQfZb.jpg",
      "original_language": "en",
      "original_title": "Schindler's List",
      "genre_ids": [
        18,
        36,
        10752
      ],
      "title": "Schindler's List",
      "vote_average": 8.6,
      "overview": "The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.",
      "release_date": "1993-11-30"
    },
    {
      "stars": "Melanie Zanetti, Giulio Berruti, James Andrew Fraser",
      "popularity": 117.149,
      "vote_count": 6330,
      "video": false,
      "poster_path": "/q719jXXEzOoYaps6babgKnONONX.jpg",
      "id": 372058,
      "adult": false,
      "backdrop_path": "/mMtUybQ6hL24FXo0F3Z4j2KG7kZ.jpg",
      "original_language": "ja",
      "original_title": "君の名は。",
      "genre_ids": [
        16,
        18,
        10749
      ],
      "title": "Your Name.",
      "vote_average": 8.6,
      "overview": "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.",
      "release_date": "2016-08-26"
    },
    {
      "stars": "Melanie Zanetti, Giulio Berruti, James Andrew Fraser",
      "popularity": 42.327,
      "id": 240,
      "video": false,
      "vote_count": 7682,
      "vote_average": 8.6,
      "title": "The Godfather: Part II",
      "release_date": "1974-12-20",
      "original_language": "en",
      "original_title": "The Godfather: Part II",
      "genre_ids": [
        18,
        80
      ],
      "backdrop_path": "/poec6RqOKY9iSiIUmfyfPfiLtvB.jpg",
      "adult": false,
      "overview": "In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba.",
      "poster_path": "/hek3koDUyRQk7FIhPXsa6mT2Zc3.jpg"
    },
        {
          "stars": "Melanie Zanetti, Giulio Berruti, James Andrew Fraser",
          "popularity": 45.213,
          "vote_count": 413,
          "video": false,
          "poster_path": "/h1B7tW0t399VDjAcWJh8m87469b.jpg",
          "id": 556574,
          "adult": false,
          "backdrop_path": "/uWVkEo9PWHu9algZsiLPi6sRU64.jpg",
          "original_language": "en",
          "original_title": "Hamilton",
          "genre_ids": [
            18,
            36,
            10402
          ],
          "title": "Hamilton",
          "vote_average": 8.5,
          "overview": "Presenting the tale of American founding father Alexander Hamilton, this filmed version of the original Broadway smash hit is the story of America then, told by America now.",
          "release_date": "2020-07-03"
        },
        {
          "stars": "Melanie Zanetti, Giulio Berruti, James Andrew Fraser",
          "popularity": 41.745,
          "vote_count": 10913,
          "video": false,
          "poster_path": "/velWPhVMQeQKcxggNEU8YmIo52R.jpg",
          "id": 497,
          "adult": false,
          "backdrop_path": "/xMIyotorUv2Yz7zpQz2QYc8wkWB.jpg",
          "original_language": "en",
          "original_title": "The Green Mile",
          "genre_ids": [
            80,
            18,
            14
          ],
          "title": "The Green Mile",
          "vote_average": 8.5,
          "overview": "A supernatural tale set on death row in a Southern prison, where gentle giant John Coffey possesses the mysterious power to heal people's ailments. When the cell block's head guard, Paul Edgecomb, recognizes Coffey's miraculous gift, he tries desperately to help stave off the condemned man's execution.",
          "release_date": "1999-12-10"
        },
        {
          "stars": "Melanie Zanetti, Giulio Berruti, James Andrew Fraser",
          "popularity": 52.964,
          "vote_count": 19511,
          "video": false,
          "poster_path": "/plnlrtBUULT0rh3Xsjmpubiso3L.jpg",
          "id": 680,
          "adult": false,
          "backdrop_path": "/52StM7zDmcjeKxWkW55X5LtoLQi.jpg",
          "original_language": "en",
          "original_title": "Pulp Fiction",
          "genre_ids": [
            80,
            53
          ],
          "title": "Pulp Fiction",
          "vote_average": 8.5,
          "overview": "A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.",
          "release_date": "1994-09-10"
        }
  ]

""".trimIndent()




