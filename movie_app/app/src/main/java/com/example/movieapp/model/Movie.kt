package com.example.movieapp.model

data class Movie(
    val id: String,
    val title: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val poster: String,
    val image: List<String>,
    val rating: String
)

fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            id = "1",
            title = "Avatar",
            genre = "Science Fiction",
            director = "James Cameron",
            actors = "Sam Worthington, Zoe Saldana, Sigourney Weaver",
            plot = "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
            poster = "avatar_poster.jpg",
            image = listOf("avatar_image1.jpg", "avatar_image2.jpg"),
            rating = "8.1"
        ),
        // Filme 2
        Movie(
            id = "2",
            title = "300",
            genre = "Action",
            director = "Zack Snyder",
            actors = "Gerard Butler, Lena Headey, David Wenham",
            plot = "King Leonidas of Sparta and a force of 300 men fight the Persians at Thermopylae in 480 B.C.",
            poster = "300_poster.jpg",
            image = listOf("300_image1.jpg", "300_image2.jpg"),
            rating = "7.6"
        ),
        // Filme 3
        Movie(
            id = "3",
            title = "Harry Potter and the Sorcerer's Stone",
            genre = "Fantasy",
            director = "Chris Columbus",
            actors = "Daniel Radcliffe, Rupert Grint, Emma Watson",
            plot = "An orphaned boy enrolls in a school of wizardry, where he learns the truth about himself, his family, and the terrible evil that haunts the magical world.",
            poster = "harry_potter_poster.jpg",
            image = listOf("harry_potter_image1.jpg", "harry_potter_image2.jpg"),
            rating = "7.6"
        ),
        // Filme 4
        Movie(
            id = "4",
            title = "Cross the Line",
            genre = "Drama",
            director = "David Victori",
            actors = "Mario Casas, Maria Valverde, Milena Smit",
            plot = "A man takes matters into his own hands when a pharmaceutical kingpin moves into his town to cause some real trouble.",
            poster = "cross_the_line_poster.jpg",
            image = listOf("cross_the_line_image1.jpg", "cross_the_line_image2.jpg"),
            rating = "6.0"
        ),
        // Filme 5
        Movie(
            id = "5",
            title = "Be Happy",
            genre = "Comedy",
            director = "Nacho G. Velilla",
            actors = "Ricardo Darín, Luis Brandoni, Verónica Llinás",
            plot = "A tale of a long-lost book that mysteriously reappears and connects an old man searching for his son with a girl seeking a cure for her mother's loneliness.",
            poster = "be_happy_poster.jpg",
            image = listOf("be_happy_image1.jpg", "be_happy_image2.jpg"),
            rating = "7.3"
        ),
        // Filme 6
        Movie(
            id = "6",
            title = "Happy Feet",
            genre = "Animation",
            director = "George Miller",
            actors = "Elijah Wood, Brittany Murphy, Hugh Jackman",
            plot = "Into the world of the Emperor Penguins, who find their soul mates through song, a penguin is born who cannot sing. But he can tap dance something fierce!",
            poster = "happy_feet_poster.jpg",
            image = listOf("happy_feet_image1.jpg", "happy_feet_image2.jpg"),
            rating = "6.4"
        ),
        // Filme 7
        Movie(
            id = "7",
            title = "Life",
            genre = "Science Fiction",
            director = "Daniel Espinosa",
            actors = "Jake Gyllenhaal, Rebecca Ferguson, Ryan Reynolds",
            plot = "A team of scientists aboard the International Space Station discover a rapidly evolving life form that caused extinction on Mars and now threatens all life on Earth.",
            poster = "life_poster.jpg",
            image = listOf("life_image1.jpg", "life_image2.jpg"),
            rating = "6.6"
        ),
        // Filme 8
        Movie(
            id = "8",
            title = "The Dark Knight",
            genre = "Action",
            director = "Christopher Nolan",
            actors = "Christian Bale, Heath Ledger, Aaron Eckhart",
            plot = "When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
            poster = "dark_knight_poster.jpg",
            image = listOf("dark_knight_image1.jpg", "dark_knight_image2.jpg"),
            rating = "9.0"
        ),
        // Filme 9
        Movie(
            id = "9",
            title = "Inception",
            genre = "Science Fiction",
            director = "Christopher Nolan",
            actors = "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page",
            plot = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
            poster = "inception_poster.jpg",
            image = listOf("inception_image1.jpg", "inception_image2.jpg"),
            rating = "8.8"
        ),
        // Filme 10
        Movie(
            id = "10",
            title = "Pulp Fiction",
            genre = "Crime",
            director = "Quentin Tarantino",
            actors = "John Travolta, Uma Thurman, Samuel L. Jackson",
            plot = "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
            poster = "pulp_fiction_poster.jpg",
            image = listOf("pulp_fiction_image1.jpg", "pulp_fiction_image2.jpg"),
            rating = "8.9"
        )
    )
}
