package songsProject;


	import java.util.HashMap;
	import java.util.LinkedList;
	import java.util.Map;

	public class RecentlyPlayedStore {
	    private final int initialCapacity;
	    private final int maxSongsPerUser;
	    private final Map<String, LinkedList<String>> store;

	    public RecentlyPlayedStore(int initialCapacity, int maxSongsPerUser) {
	        this.initialCapacity = initialCapacity;
	        this.maxSongsPerUser = maxSongsPerUser;
	        this.store = new HashMap<>(initialCapacity);
	    }

	    public void addSong(String user, String song) {
	        if (!store.containsKey(user)) {
	            store.put(user, new LinkedList<>());
	        }

	        LinkedList<String> songsList = store.get(user);
	        if (songsList.size() >= maxSongsPerUser) {
	            songsList.removeFirst();
	        }
	        songsList.addLast(song);
	    }

	    public LinkedList<String> getRecentlyPlayedSongs(String user) {
	        return store.getOrDefault(user, new LinkedList<>());
	    }

	    public static void main(String[] args) {
	        RecentlyPlayedStore store = new RecentlyPlayedStore(10, 5);
	        store.addSong("Alice", "Song1");
	        store.addSong("Bob", "Song2");
	        store.addSong("Alice", "Song3");
	        store.addSong("Bob", "Song4");
	        store.addSong("Alice", "Song5");
	        store.addSong("Bob", "Song6");

	        System.out.println("Recently played songs for Alice: " + store.getRecentlyPlayedSongs("Alice"));
	        System.out.println("Recently played songs for Bob: " + store.getRecentlyPlayedSongs("Bob"));
	    }
	}


