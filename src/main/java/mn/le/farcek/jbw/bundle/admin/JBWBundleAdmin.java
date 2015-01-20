/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.le.farcek.jbw.bundle.admin;

import java.io.InputStream;
import java.util.List;
import mn.le.farcek.jbw.api.Bundle;
import mn.le.farcek.jbw.api.IBundle;
import mn.le.farcek.jbw.api.bundle.BundleInjector;
import mn.le.farcek.jbw.api.bundle.JBWBundle;
import mn.le.farcek.jbw.api.exception.MissingAsset;

/**
 *
 * @author Farcek
 */
@Bundle(name = "admin")
@BundleInjector(AdminInjector.class)
public class JBWBundleAdmin extends JBWBundle {

    @Override
    protected void setupControllers(List<Class<?>> controllers) {

    }
}
