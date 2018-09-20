/********* back2native.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface back2native : CDVPlugin {
  // Member variables go here.
}

- (void)back:(CDVInvokedUrlCommand*)command;
@end

@implementation back2native

- (void)back:(CDVInvokedUrlCommand *)command {
    [self dismiss:command];
    [self pop:command];
}

- (void)dismiss:(CDVInvokedUrlCommand *)command {
  [self.viewController dismissViewControllerAnimated:YES completion:nil];
}

- (void)pop:(CDVInvokedUrlCommand *)command {
    [(UINavigationController*)self.viewController.parentViewController popViewControllerAnimated:YES];
}

@end
