/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class 690EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        for ( Employee target: employees ){
            if (target.id == id ){
                int sum = target.importance;
                if ( target.subordinates.isEmpty() ) return target.importance;
                for ( int i : target.subordinates ){
                    sum += getImportance(employees, i);
                }
                return sum;  
            }
        }
        return 0;
    }
}