public class SimpleHashtable {
    private SavedPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);

        // already correct hashedKey
        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        // perform linear probing
        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) { // end of array
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex &&
                isOccupied(hashedKey) &&
                !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) { // saved player found
            return  hashedKey;
        }

        return -1;
    }

    public boolean isOccupied(int hashedKey) {
        return hashtable[hashedKey] != null;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        // perform linear probing
        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {    // hashed key is already at the end of the array
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            while (hashedKey != stoppingIndex && hashtable[hashedKey] != null) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {    // hashed key is already taken
            System.out.println("Cannot put player " + key + ". Hashtable is full.");
        }
        else {
            hashtable[hashedKey] = new SavedPlayer(key, value);
        }
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }

        return hashtable[hashedKey].getValue();
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            Player player = null;

            if (hashtable[i] != null)
                player = hashtable[i].getValue();

            System.out.println("Element " + i + " = " + player);
        }
    }
    public void remove(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            System.out.println("Cannot remove player " + key + ". Key not found.");
            return;
        }

        // Remove the element
        hashtable[hashedKey] = null;
        System.out.println("Player " + key + " removed successfully.");

        //Rehash to fix the sequence
        int currentIndex = (hashedKey + 1) % hashtable.length;

        while (isOccupied(currentIndex)) {
            SavedPlayer entry = hashtable[currentIndex];
            String entryKey = entry.getKey();
            int originalHash = hashKey(entryKey);

            //Checker to see any 'holes' in the path, the hole will be filled with a new data
            if ((originalHash <= hashedKey && hashedKey < currentIndex) ||
                    (currentIndex < originalHash && originalHash <= hashedKey) ||
                    (hashedKey < currentIndex && currentIndex < originalHash)) {

                //The moving truck of the data idk what to call this lol, how do you do this formally
                //this just moves the entry into where the deleted data was
                hashtable[hashedKey] = entry;
                hashtable[currentIndex] = null;

                hashedKey = currentIndex;
            }

            currentIndex = (currentIndex + 1) % hashtable.length;
        }
    }
}