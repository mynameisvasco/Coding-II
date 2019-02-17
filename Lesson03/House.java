public class House
{
    private String type;
    private int size;
    private int mem;
    private int extraMem;
    private Room[] rooms;


    public House(String type)
    {
        this.type = type;
        this.mem = 8;
        this.extraMem = this.mem + 4;
        this.rooms = new Room[this.mem + this.extraMem];
    }

    public House(String type, int mem, int extraMem)
    {
        this.type = type;
        this.mem = mem;
        this.extraMem = extraMem;
        this.rooms = new Room[this.mem + this.extraMem];
    }

    public void addRoom(Room room)
    {
        rooms[size] = new Room(room.bottomLeft(), room.topRight(), room.roomType());
        size++; 
    }

    public int size()
    {
        return this.size;
    }

    public int maxSize()
    {
        if(this.size > this.mem)
        {
            return this.mem + this.extraMem;
        }
        else
        {
            return this.mem;
        }
    }

    public Room room(int i)
    {
        return rooms[i];
    }

    public double area()
    {
        double totalArea = 0;

        for(int i = 0; i < this.size; i++)
        {
            totalArea += rooms[i].area();
        }

        return totalArea;
    }

    public RoomTypeCount[] getRoomTypeCounts()
    {
        int div = 0;
        RoomTypeCount[] rt = new RoomTypeCount[this.size];

        for(int i = 0; i < this.size; i++)
        {
            for(int k = 0; k < this.size; k++)
            {
                if(rt[k] == null)
                {
                    rt[div] = new RoomTypeCount();
                    rt[div].roomType = rooms[i].roomType();
                    rt[div].count++;
                    div++;
                    break;
                }
                else if(rt[k].roomType.equals(rooms[i].roomType()))
                {
                    rt[k].count++;
                    break;
                }
                else
                {
                    continue;
                }
            }
        }
        
        return rt;
    }
  
    public double averageRoomDistance()
    {
        double totalDistance = 0;

        for(int k = 1; k < this.size; k++)
        {
            totalDistance += rooms[0].geomCenter().distTo(rooms[k].geomCenter());
        }
        

        return totalDistance/this.size;
    }
}