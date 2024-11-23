public enum CostType {
    REFUELING("Tankowanie"),
    SERVICE("Serwis"),
    PARKING("Parking"),
    INSURANCE("Ubezpieczenie"),
    TICKET("Mandat");

    private final String costType;

    CostType(String costType) {
        this.costType = costType;
    }

    public String getCostType() {
        return costType;
    }
}