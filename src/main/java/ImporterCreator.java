public class ImporterCreator {
    public static Importer createImporter(Site type) throws Exception {

        switch (type) {
            case CAPTERRA:
                return new YamlImporter();
            case SOFTWAREADVICE:
                return new JsonImporter();
            case OTHERPROVIDER:
                return new OnLineImporter();
            default:
               throw new Exception ("Provider not found");
        }
    }
}
