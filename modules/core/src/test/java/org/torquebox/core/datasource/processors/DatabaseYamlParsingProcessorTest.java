package org.torquebox.core.datasource.processors;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.projectodd.polyglot.test.as.MockDeploymentUnit;
import org.torquebox.core.datasource.DatabaseMetaData;
import org.torquebox.test.as.AbstractDeploymentProcessorTestCase;

public class DatabaseYamlParsingProcessorTest extends AbstractDeploymentProcessorTestCase {

    @Before
    public void setUp() throws Throwable {
        clearDeployers();
        appendDeployer( new DatabaseYamlParsingProcessor() );
    }

    @Test
    public void testRails3DatabaseYaml() throws Exception {
        MockDeploymentUnit unit = deployResourceAs( "rails3-database.yml", "database.yml" );

        List<DatabaseMetaData> allMetaData = unit.getAttachmentList( DatabaseMetaData.ATTACHMENTS );
        assertEquals( 4, allMetaData.size() );
    }

    @Test
    public void testErbInDatabaseYaml() throws Exception {
        MockDeploymentUnit unit = deployResourceAs( "erb-in-database.yml", "database.yml" );

        List<DatabaseMetaData> allMetaData = unit.getAttachmentList( DatabaseMetaData.ATTACHMENTS );
        assertEquals( 0, allMetaData.size() );
    }

}
