package database;

public class Queries {
    public static final String CREATE_RESULTS_TABLE = """
            CREATE TABLE IF NOT EXISTS RESULTS(
            id serial primary key,
            x  double precision NOT NULL,
            y double precision NOT NULL,
            r double precision NOT NULL,
            inArea boolean NOT NULL,
            received timestamp NOT NULL,
            executionTime varchar(20)
            );
            """;

    public static String ADD_RESULT = """
            INSERT into RESULTS(x,y,r,inArea,received,executionTime)
            VALUES(?,?,?,?,?,?);
            """;

    public static String REMOVE_ALL_RESULTS = """
            DELETE * from RESULTS;
            """;

    public static String GET_ALL_RESULTS = """
            SELECT * from results;
            """;
}
