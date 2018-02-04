Basic Flow :

datacache directory : ProductDataCache, ProfessionalDataCache are basically cache to hold the data for our application
Controller will call specific service APIs which will use ProductDao, ProfessionalDao interface to serve the requests.
The dao layer will use the caches as a data store, for a large application we can chose to persist the data in the databases etc.
