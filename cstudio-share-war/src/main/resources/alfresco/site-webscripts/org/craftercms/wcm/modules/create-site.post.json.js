function main()
{
   // Get clients json request as a "normal" js object literal
   var clientRequest = json.toString();
   var clientJSON = eval('(' + clientRequest + ')');


   // Call the repo to create the site
   var scriptRemoteConnector = remote.connect("alfresco");
   var repoResponse = scriptRemoteConnector.post("/api/sites", clientRequest, "application/json");
   if (repoResponse.status == 401)
   {
      status.setCode(repoResponse.status, "error.loggedOut");
      return;
   }
   else
   {
 
 var shortname = "";
 var blueprint = "";
 
 var repoJSON = eval('(' + repoResponse + ')');

      // Check if we got a positive result
      if (repoJSON.shortName)
      {
    	  shortname = repoJSON.shortName;
    	  blueprint = clientJSON.siteBlueprint;
         
    	  // Yes we did, now create the site in the webtier
         var tokens = new Array();
         tokens["siteid"] = repoJSON.shortName;
         sitedata.newPreset(clientJSON.sitePreset, tokens);

         model.success = true;
      }
      else if (repoJSON.status.code)
      {
         status.setCode(repoJSON.status.code, repoJSON.message);
         return;
      }


      var repoResponse = scriptRemoteConnector.get("/cstudio/site/create-site?site="+shortname+"&blueprint="+blueprint);

      repoResponse = scriptRemoteConnector.get("/cstudio/site/reload-config");

      repoResponse = scriptRemoteConnector.post("/cstudio/wcm/sync/sync-site?site="+shortname, "", "application/json"); 
   }
}

main();
