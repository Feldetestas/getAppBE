public class Runner {
    public static void main(String[] args) {

            if (args.length <= 0 || args.length > 2) {
                System.out.println("Wrong number of parameters");
                return;
            }
            String site = args[0];
            String path = args[1];

        try {
            Importer importer = ImporterCreator.createImporter(Site.valueOf(site.toUpperCase()));
            importer.doImport(path);
        } catch (IllegalArgumentException e) {
            System.out.print("Site not found");
        }catch (Exception ex){
            System.out.println("Runtime error:"+ ex.getMessage());
        }

    }

}
