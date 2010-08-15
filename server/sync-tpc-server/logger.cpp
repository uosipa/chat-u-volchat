#include "logger.hpp"
#include "log_appender.hpp"

#include <string>

using com::uosipa::chatuvolchat::logger;
using std::string;

logger::logger(const string& id):
id(id)
{
    // No operations.
}

void logger::info(const string& message)
{
    append(INF, id, message);
}

void logger::warn(const string& message)
{
    append(WRN, id, message);
}
