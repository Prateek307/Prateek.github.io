

// A server that holds list of all machines 
class Server 
{ 
    HashMap<Integer, Machine> machines = 
                       new HashMap<Integer, Machine>(); 
    HashMap<Integer, Integer> personToMachineMap = 
                        new HashMap<Integer, Integer>(); 
  
    public Machine getMachineWithid(int machineID) 
    { 
        return machines.get(machineID); 
    } 
  
    public int getMachineIDForUser(int personID) 
    { 
        Integer machineID = personToMachineMap.get(personID); 
        return machineID == null ? -1 : machineID; 
    } 
  
    public Person getPersonWithID(int personID) 
    { 
        Integer machineID = personToMachineMap.get(personID); 
        if (machineID == null) return null; 
  
        Machine machine = getMachineWithid(machineID); 
        if (machine == null) return null; 
  
        return machine.getPersonWithID(personID); 
    } 
} 
  
// A person on social network has id, friends and other info 
class Person 
{ 
    private Arraylist<Integer> friends = 
                               new Arraylist<Integer>(); 
    private int personID; 
    private String info; 
  
    public Person(int id) 
    { 
        this.personID =id; 
    } 
    public String getinfo() 
    { 
        return info; 
    } 
    public void setinfo(String info) 
    { 
        this.info = info; 
    } 
    public Arraylist<Integer> getFriends() 
    { 
        return friends; 
    } 
    public int getID() 
    { 
        return personID; 
    } 
    public void addFriend(int id) 
    { 
        friends.add(id); 
    } 
} 