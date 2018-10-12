package data7.project;

/*-
 * #%L
 * Data7
 * %%
 * Copyright (C) 2018 University of Luxembourg, Matthieu Jimenez
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */



import java.util.HashMap;
import java.util.Map;

import static data7.project.AndroidMetaInf.ANDROID_NVD;
import static data7.project.AndroidMetaInf.getAndroid;
import static data7.project.CMetaInf.*;

public class ProjectFactory {



    public static Project retrieveProjectInfo(String name) {
        Map<String,MetaInformation> mapProject = new HashMap<>();
        switch (name) {
            case LINUX_NVD:
                mapProject.put(LINUX_NVD,LINUX_KERNEL);
                return new Project(LINUX_NVD,mapProject);
            case OPENSSL_NVD:
                mapProject.put(OPENSSL_NVD,OPEN_SSL);
                return new Project(OPENSSL_NVD,mapProject);
            case WIRESHARK_NVD:
                mapProject.put(WIRESHARK_NVD,WIRESHARK);
                return new Project(WIRESHARK_NVD,mapProject);
            case SYSTEMD_NVD:
                mapProject.put(SYSTEMD_NVD,SYSTEMD);
                return new Project(SYSTEMD_NVD,mapProject);
            case ANDROID_NVD:
                return new Project(ANDROID_NVD,getAndroid());
            default:
                return null;
        }
    }

}
