class Student {

    String imie, nazwisko;
    int numerIndeksu;
    static int liczbaStudentow = 0;

    public Student (String imie, String nazwisko, int numerIndeksu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerIndeksu = numerIndeksu;
        liczbaStudentow++;
    }

    public void przedstawSie() {
        System.out.println(nazwisko + " " + imie + " " + numerIndeksu);
    }

    public static int liczbaStudentow() {
        return liczbaStudentow;
    }

    public static void main(String[] args){
        Student s1 = new Student("Jan", "Kowalski", 2801);
        Student s2 = new Student("Ola", "Nowak", 8410);
        Student s3 = new Student("Adam", "Lewandowski", 5771);

        s1.przedstawSie();
        s2.przedstawSie();
        s3.przedstawSie();

        System.out.println("Liczba studentow wynosi: " + liczbaStudentow);
    }
    
}