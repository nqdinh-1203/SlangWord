public class Menu {
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void mainMenu()
    {
        ClearConsole();
        System.out.println("==================MENU===================");
        System.out.println("1. Search slang word by slang");
        System.out.println("2. Search slang word by definition/meaning");
        System.out.println("3. Show Search History");
        System.out.println("4. Add slang word");
        System.out.println("5. Edit slang word");
        System.out.println("6. Delete slang word");
        System.out.println("7. Reset original slang words file");
        System.out.println("8. On this day slang word");
        System.out.println("9. Game: Guess slang from definition");
        System.out.println("10. Game: Guess definition from slang");
        System.out.println("0. Exit");
        System.out.print("Input your choice: ");
    }
}
