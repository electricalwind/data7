package data7.importer.cwe;

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

import com.opencsv.CSVReader;
import data7.Resources;
import data7.ResourcesPath;
import data7.model.CWE;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CWEParser {

    static List<CWE> parse(ResourcesPath path) throws FileNotFoundException {
        CSVReader reader = new CSVReader(new FileReader(path.getCvePath() + Resources.CWE_XML_FILE));
        Iterator<String[]> iterator = reader.iterator();
        String[] line = iterator.next();
        List<CWE> cwes = new ArrayList<>();
        while (iterator.hasNext()) {
            line = iterator.next();
            String child = line[6];
            Pattern pattern = Pattern.compile("CWE ID:([0-9]+)");
            List<String> allMatches = new ArrayList<>();
            Matcher matcher = pattern.matcher(child);
            while (matcher.find()) {
                allMatches.add(matcher.group(1));
            }
            Set<Integer> childOf = new HashSet<>();
            for (String c : allMatches) {
                childOf.add(Integer.parseInt(c));
            }
            CWE cwe = new CWE(Integer.parseInt(line[0]), line[1], line[4], new ArrayList<>(childOf));
            cwes.add(cwe);
        }
        return cwes;
    }
}
