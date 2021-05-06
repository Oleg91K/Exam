package exam;

public enum TypeTickets {
    SINGLE_TICKET(8, 22, false, true, true),
    DAILY_TICKET(8, 16, false, true, false),
    FULL_TICKET(8, 22, true, true, true);

    private final int startTime;
    private final int endTime;
    private final boolean accessGroup;
    private final boolean accessGym;
    private final boolean accessPool;

    TypeTickets(int startTime, int endTime, boolean accessGroup, boolean accessGym, boolean accessPool) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.accessGroup = accessGroup;
        this.accessGym = accessGym;
        this.accessPool = accessPool;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public boolean isAccessGroup() {
        return accessGroup;
    }

    public boolean isAccessGym() {
        return accessGym;
    }

    public boolean isAccessPool() {
        return accessPool;
    }
}

